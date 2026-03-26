package com.example.cvcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                CVScreen()
            }
        }
    }
}

@Composable
fun CVScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.elfoto),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // NAMA
        Text(
            text = "Devanida Ratna Adiningrum",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "NIM: 245150700111043",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Riwayat Pendidikan")

        CardItem("""
            2021 - Sekarang
            Universitas Brawijaya
            S1 Teknologi Informasi

            2018 - 2021
            SMAN 1 Batu

            2015 - 2018
            SMPN 1 Batu
        """.trimIndent())

        SectionTitle("Tentang Saya")

        CardItem("""
            Mahasiswa Teknologi Informasi dengan pengalaman 5 tahun sebagai freelance digital artist. 
            Memiliki minat di bidang desain, UI/UX, dan pengembangan aplikasi.
        """.trimIndent())

        SectionTitle("Skill")

        CardItem("""
            • UI/UX Design
            • Front-End Development
            • Digital Illustration
        """.trimIndent())
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun CardItem(content: String) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = content,
            modifier = Modifier.padding(16.dp)
        )
    }
}