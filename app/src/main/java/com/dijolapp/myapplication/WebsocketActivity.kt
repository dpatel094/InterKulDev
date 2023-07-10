package com.dijolapp.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.json.JSONObject
import java.net.URI
import java.net.URISyntaxException


class WebsocketActivity : AppCompatActivity() {
    private var connectButton: Button? = null
    private var disconnectButton: Button? = null
    private var outputTxt: TextView? = null
    private var webSocketClient: WebSocketClient? = null
    private var rv: RecyclerView? = null
    private var websocketAdapter: WebsocketAdapter? = null
    private val WEBSOCKET_URL = "wss://stream.binance.com:9443/ws/bnbusdt@trade"
    var websocketItems: ArrayList<WebsocketItem>? = null

//btcusdt@trade
    //bnbusdt@trade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_websocket)
        connectButton = findViewById(R.id.connectButton)
        disconnectButton = findViewById(R.id.disconnectButton)
        rv = findViewById(R.id.recyclerView)
        outputTxt = findViewById(R.id.output)

        connectButton!!.setOnClickListener(View.OnClickListener { connectWebSocket() })

        disconnectButton!!.setOnClickListener(View.OnClickListener { disconnectWebSocket() })
        websocketItems = ArrayList<WebsocketItem>()
        rv!!.layoutManager = GridLayoutManager(this,2)


         websocketAdapter = WebsocketAdapter(websocketItems)

        rv!!.adapter = websocketAdapter

    }

    private fun connectWebSocket() {
        val uri: URI = try {
            URI(WEBSOCKET_URL)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            return
        }
        webSocketClient = object : WebSocketClient(uri) {
            override fun onOpen(handshakedata: ServerHandshake) {
                runOnUiThread {
                    connectButton!!.isEnabled = false
                    disconnectButton!!.isEnabled = true
                }
            }

            override fun onMessage(message: String) {
                getValue(message)
                Log.i("Resposne", message)
            }

            override fun onClose(code: Int, reason: String, remote: Boolean) {
                runOnUiThread {
                    connectButton!!.isEnabled = true
                    disconnectButton!!.isEnabled = false
                }
            }

            override fun onError(ex: Exception) {
                runOnUiThread { ex.printStackTrace() }
            }
        }
        webSocketClient!!.connect()
    }
    private fun disconnectWebSocket() {
        if (webSocketClient != null) {
            webSocketClient!!.close()
            webSocketClient = null
        }
    }
    var oldPrice = 0.0
    var price = 0.0
    var color = "#00FF00"
    @SuppressLint("NotifyDataSetChanged")
    fun  getValue(message :String){
        val data = JSONObject(message)
        price = data.getDouble("p")
        val trade = if (price > oldPrice) {
            color ="#4582C3"
        } else if (price == oldPrice) {
            color ="#8cff1a"
        } else {
            color ="#CBB880"
        }
        oldPrice = price
        println(trade)
        outputTxt!!.text = HtmlCompat.fromHtml("<font color=\"$color\">Price : $oldPrice</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        val websocketItem = WebsocketItem.fromJson(data)
        Thread {
            runOnUiThread {
        websocketItems?.add(websocketItem)
        websocketAdapter?.notifyDataSetChanged()
            }
        }.run()

    }

    override fun onDestroy() {
        super.onDestroy()
        disconnectWebSocket()
    }

}