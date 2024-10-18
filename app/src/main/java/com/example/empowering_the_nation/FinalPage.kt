package com.example.empowering_the_nation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FinalPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_page)

        // Setting up system bars insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val facebookLink: TextView = findViewById(R.id.facebook_Link)
        val twitterLink: TextView = findViewById(R.id.twitter_Link)
        val instagramLink: TextView = findViewById(R.id.instagram_Link)


        facebookLink.setOnClickListener {
            openSocialMediaLink("https://eur03.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.facebook.com%2Fprofile.php%3Fid%3D61567428503962&data=05%7C02%7CST10440331%40vcconnect.edu.za%7C3783c9ca8e2d494c6a8708dcedb092e7%7Ce10c8f44f469448fbc0dd781288ff01b%7C0%7C0%7C638646589849381830%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C0%7C%7C%7C&sdata=yxAED2RHWr5cz%2BA89IzDmb93IkZ554QG1edsxVC6qMw%3D&reserved=0")
        }

        twitterLink.setOnClickListener {
            openSocialMediaLink("https://eur03.safelinks.protection.outlook.com/?url=https%3A%2F%2Fx.com%2Fempowering_2018&data=05%7C02%7CST10440331%40vcconnect.edu.za%7Cd124c3ca8cef4c38375908dcedb1a5c0%7Ce10c8f44f469448fbc0dd781288ff01b%7C0%7C0%7C638646594445546483%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C0%7C%7C%7C&sdata=352y1wQLH0C6AjfrENyIACp6PjuaH0naszI9FzS6Y%2F0%3D&reserved=0")
        }

        instagramLink.setOnClickListener {
            openSocialMediaLink("https://eur03.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.instagram.com%2Fempo_weringthenation%2F&data=05%7C02%7CST10440331%40vcconnect.edu.za%7Cd124c3ca8cef4c38375908dcedb1a5c0%7Ce10c8f44f469448fbc0dd781288ff01b%7C0%7C0%7C638646594445571928%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C0%7C%7C%7C&sdata=9v67yuJ7c8Uk87BZwrwQTP2dPSRfx5mQlHExJOl4p1k%3D&reserved=0")
        }
    }

    // Function to open social media links
    private fun openSocialMediaLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
