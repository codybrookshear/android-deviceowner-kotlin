package co.coburglabs.mdm

import android.app.admin.DevicePolicyManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.coburglabs.mdm.ui.theme.MDMTheme

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var doMessage : String = "App's device owner state is unknown"

        if (savedInstanceState == null) {
            val manager = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
            doMessage = if (manager.isDeviceOwnerApp(applicationContext.packageName)) {
                "App is device owner"
            } else {
                "App is not device owner"
            }
        }

        Log.e(TAG, doMessage)

        setContent {
            MDMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Status(doMessage)
                }
            }
        }
    }
}

@Composable
fun Status(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun StatusPreview() {
    MDMTheme {
        Status("TBD")
    }
}