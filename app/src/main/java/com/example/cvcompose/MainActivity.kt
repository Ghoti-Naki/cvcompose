package com.example.cvcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cvcompose.ui.theme.BiodataTheme

data class ProfileData(
    val name: String,
    val nim: String,
    val className: String,
    val headline1: String,
    val headline2: String,
    val headline3: String,
    val about: String,
    val phone: String,
    val email: String,
    val linkedin: String,
    val address: String,
    val education: List<String>,
    val skillsLeft: List<String>,
    val skillsRight: List<String>,
    val languages: List<String>
)

data class ExperienceGroup(
    val year: String,
    val items: List<String>
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiodataTheme {
                BiodataApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiodataApp() {
    val profile = ProfileData(
        name = "Devanida Ratna Adiningrum",
        nim = "245150700111043",
        className = "TI-C",
        headline1 = "Undergraduate IT Student '24",
        headline2 = "Universitas Brawijaya",
        headline3 = "5 Yrs Digital Art Freelancer",
        about = "I am an IT undergraduate with five years of experience as a freelance digital artist. My work centers on visual storytelling and transforming ideas into purposeful, impactful designs. Through this journey, I have developed strong discipline, adaptability, and attention to detail, aiming to create solutions that balance functionality and aesthetics.",
        phone = "+62 895 4133 11778",
        email = "devanidaratna@student.ub.ac.id",
        linkedin = "Devanida Ratna",
        address = "Sumbersekar, Dau, Malang, East Java",
        education = listOf(
            "Universitas Brawijaya | Information Technology Undergraduate Program",
            "2021 - 2024",
            "SMAN 1 Batu | Mathematics and Natural Science Major",
            "2018 - 2021",
            "SMPN 1 Batu"
        ),
        skillsLeft = listOf(
            "2D Illustration",
            "UI/UX Design",
            "Animation",
            "Game Illustration",
            "Front End Development",
            "Junior Project Manager",
            "Graphic Design"
        ),
        skillsRight = listOf(
            "Figma",
            "Clip Studio Paint",
            "Adobe Illustrator",
            "Ibis Paint X",
            "Alight Motion",
            "Capcut",
            "Canva"
        ),
        languages = listOf(
            "English - Advanced",
            "Indonesia - Native",
            "Japanese - Beginner"
        )
    )

    val experiences = listOf(
        ExperienceGroup(
            year = "2026",
            items = listOf(
                "5 Years in digital art field and business",
                "Starting journey - POROS Filkom UB",
                "Starting journey - Raion Community",
                "Starting journey - Advanced Programming SI'25 Assistant Practicum"
            )
        ),
        ExperienceGroup(
            year = "2023",
            items = listOf(
                "Miracle in Town Event Speech Moderator - Batu City Cable Car Tourism Project with Dopplemayr Austria",
                "1st Place Regional FLS2N Digital Comic Competition, Batu City",
                "Head of Digital Comic Club - SMAN 1 Batu"
            )
        ),
        ExperienceGroup(
            year = "2020",
            items = listOf("-")
        ),
        ExperienceGroup(
            year = "2019",
            items = listOf(
                "Treasurer of Student Council - SMPN 1 Batu"
            )
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Kupunya CV",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF9CC7F3),
                            Color(0xFFDDE8D6),
                            Color(0xFFF1ECCB)
                        )
                    )
                )
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    HeroSection(profile)
                }

                item {
                    AboutCard(profile.about)
                }

                item {
                    EducationCard(profile.education)
                }

                item {
                    ExperienceCard(experiences)
                }

                item {
                    SkillsRow(
                        leftTitle = "Skills",
                        leftItems = profile.skillsLeft,
                        rightTitle = "Tools",
                        rightItems = profile.skillsRight
                    )
                }

                item {
                    LanguageCard(profile.languages)
                }

                item {
                    FooterCard(
                        name = profile.name,
                        className = profile.className,
                        nim = profile.nim
                    )
                }
            }
        }
    }
}

@Composable
fun HeroSection(profile: ProfileData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFA9C6DC)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.elfoto),
                    contentDescription = "Foto Profil",
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    Column {
                        Text(
                            text = profile.name,
                            fontSize = 20.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 3
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = profile.headline1,
                            color = Color.White,
                            fontSize = 14.sp
                        )
                        Text(
                            text = profile.headline2,
                            color = Color.White,
                            fontSize = 14.sp
                        )
                        Text(
                            text = profile.headline3,
                            color = Color.White,
                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        InfoChip("Kelas ${profile.className}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "NIM: ${profile.nim}",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            ContactItem(Icons.Default.Phone, profile.phone)
            ContactItem(Icons.Default.Email, profile.email)
            ContactItem(Icons.Default.Person, profile.linkedin)
            ContactItem(Icons.Default.LocationOn, profile.address)
        }
    }
}

@Composable
fun InfoChip(text: String) {
    Surface(
        shape = RoundedCornerShape(50),
        color = Color.White.copy(alpha = 0.22f)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ContactItem(
    icon: ImageVector,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.White,
            modifier = Modifier.size(18.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun AboutCard(about: String) {
    SectionCard(
        title = "About Me",
        icon = Icons.Default.Person
    ) {
        Text(
            text = about,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 14.sp,
            lineHeight = 22.sp
        )
    }
}

@Composable
fun EducationCard(education: List<String>) {
    SectionCard(
        title = "Education",
        icon = Icons.Default.School
    ) {
        education.forEachIndexed { index, item ->
            Text(
                text = item,
                fontSize = if (item.contains("-")) 18.sp else 14.sp,
                fontWeight = if (item.contains("-")) FontWeight.Bold else FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 22.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            if (index != education.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 4.dp),
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
                )
            }
        }
    }
}

@Composable
fun ExperienceCard(experiences: List<ExperienceGroup>) {
    SectionCard(
        title = "Experience & Achievement",
        icon = Icons.Default.Work
    ) {
        experiences.forEachIndexed { index, group ->
            Text(
                text = group.year,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            group.items.forEach { item ->
                Text(
                    text = "• $item",
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            if (index != experiences.lastIndex) {
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun SkillsRow(
    leftTitle: String,
    leftItems: List<String>,
    rightTitle: String,
    rightItems: List<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SmallListCard(
            modifier = Modifier.weight(1f),
            title = leftTitle,
            icon = Icons.Default.Build,
            items = leftItems
        )

        SmallListCard(
            modifier = Modifier.weight(1f),
            title = rightTitle,
            icon = Icons.Default.Build,
            items = rightItems
        )
    }
}

@Composable
fun SmallListCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    items: List<String>
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.82f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            items.forEach { item ->
                Text(
                    text = "• $item",
                    fontSize = 13.sp,
                    lineHeight = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
            }
        }
    }
}

@Composable
fun LanguageCard(languages: List<String>) {
    SectionCard(
        title = "Languages",
        icon = Icons.Default.Translate
    ) {
        languages.forEach { language ->
            Text(
                text = "• $language",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(vertical = 3.dp)
            )
        }
    }
}

@Composable
fun FooterCard(name: String, className: String, nim: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.22f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$name | $className | $nim",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF6B8FCF)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Pemrograman Aplikasi Mobile",
                fontSize = 13.sp,
                color = Color(0xFF7EA2DA)
            )
        }
    }
}

@Composable
fun SectionCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.82f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(14.dp))
            content()
        }
    }
}