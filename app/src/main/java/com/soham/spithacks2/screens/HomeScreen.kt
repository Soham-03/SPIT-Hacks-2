//package com.soham.spithacks2.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
//import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.google.android.gms.maps.model.LatLng
//import com.soham.NGO
//import com.soham.spithacks2.NGOCard
//import com.soham.spithacks2.R
//import com.soham.spithacks2.ui.theme.Blue
//import com.soham.spithacks2.ui.theme.darkBlue
//
//@Composable
//fun HomeScreen(){
//    var listOfColors = listOf(
//        Blue,
//        Color.White
//    )
//    Column(
//        Modifier
//            .fillMaxSize()
//            .background(brush = Brush.verticalGradient(
//                listOfColors,
//                startY = 0.0f,
//                endY = Float.POSITIVE_INFINITY
//            ))
//            .padding(12.dp)
//    ){
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ){
//            Column(
//            ){
//                Text(
//                    text = "Aryan Caterers",
//                    color = Color.Black,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.SemiBold,
//
//                    )
//                Text(
//                    text = "Andheri, Mumbai",
//                    color = Color.Black,
//                    fontSize = 14.sp,
//                )
//            }
//            Image(
//                painter = painterResource(
//                    R.drawable.ic_launcher_background,
//                ),
//                contentScale = ContentScale.Crop,
//                contentDescription = "Image of hotel",
//                modifier = Modifier
//                    .size(54.dp)
//                    .clip(CircleShape)
//            )
//        }
//        Spacer(Modifier.height(18.dp))
//        Text(
//            text = "Hello, Aryan Caterers",
//            fontWeight = FontWeight.Bold,
//            fontSize = 28.sp
//        )
//        Text(
//            text = "There are 2 NGO's",
//            fontWeight = FontWeight.Bold,
//            fontSize = 28.sp,
//            color = darkBlue
//        )
//        Text(
//            text = "near your location",
//            fontWeight = FontWeight.Bold,
//            fontSize = 28.sp,
//            color = darkBlue
//        )
//        val listOfNGO = listOf(
//            NGO(
//                name = "Feeding India",
//                location = LatLng(19.044414097731117, 72.82033831437562),
//                members = "1000",
//                feeding = "100",
//                donorImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuP0hq62APhBHQvN0qiB4ay9p-5RZD85HmcA&s",
//                foodImage = "https://imgmedia.lbb.in/media/2021/04/6089414c6fbdfe713133e9bc_1619607884604.jpg",
//            ),
//            NGO(
//                name = "Feeding India",
//                location = LatLng(19.044414097731117, 72.82033831437562),
//                members = "1000",
//                feeding = "100",
//                donorImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuP0hq62APhBHQvN0qiB4ay9p-5RZD85HmcA&s",
//                foodImage = "https://imgmedia.lbb.in/media/2021/04/6089414c6fbdfe713133e9bc_1619607884604.jpg",
//            )
//
//        )
//        LazyVerticalStaggeredGrid(
//            columns =  StaggeredGridCells.Fixed(2),
//        ) {
//            for(ngo in listOfNGO){
//                item {
//                    NGOCard(ngo)
//                }
//            }
//        }
//    }
//}

package com.soham.spithacks2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.android.gms.maps.model.LatLng
import com.soham.NGO
import com.soham.spithacks2.NGOCard
import com.soham.spithacks2.R
import com.soham.spithacks2.ui.theme.Blue
import com.soham.spithacks2.ui.theme.darkBlue

@Composable
fun HomeScreen() {
    var listOfColors = listOf(
        Blue,
        Color.White
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOfColors,
                    startY = 0.0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Aryan Caterers",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "Andheri, Mumbai",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }
            Image(
                painter = rememberAsyncImagePainter(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShMw7itm5NFNon2D1L8D9LfBTlmubgIo6s3g&s"
                ),
                contentScale = ContentScale.Crop,
                contentDescription = "Image of hotel",
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(Modifier.height(18.dp))
        Text(
            text = "Hello, Aryan Caterers",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Text(
            text = "There are 6 NGO's",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = darkBlue
        )
        Text(
            text = "near your location",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = darkBlue
        )

        Spacer(Modifier.height(16.dp))

        val listOfNGO = listOf(
            NGO(
                name = "Feeding India",
                location = LatLng(19.044414097731117, 72.82033831437562),
                members = "1000+",
                feeding = "250",
                donorImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuP0hq62APhBHQvN0qiB4ay9p-5RZD85HmcA&s",
                foodImage = "https://imgmedia.lbb.in/media/2021/04/6089414c6fbdfe713133e9bc_1619607884604.jpg",
            ),
            NGO(
                name = "Robin Hood Army",
                location = LatLng(19.051428, 72.821614),
                members = "750+",
                feeding = "180",
                donorImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKnBpBHEJ6BKGIm--FQEXoNMsvaYUYVTagDQ&s",
                foodImage = "https://imgstaticcontent.lbb.in/lbbnew/wp-content/uploads/sites/7/2017/08/08140953/12072017_robinhoodarmy01.jpg",
            ),
            NGO(
                name = "Akshaya Patra",
                location = LatLng(19.039776, 72.838495),
                members = "1200+",
                feeding = "300",
                donorImage = "https://media.licdn.com/dms/image/v2/C510BAQHeC84deg7YVQ/company-logo_200_200/company-logo_200_200/0/1630618546994/the_akshaya_patra_foundation_logo?e=2147483647&v=beta&t=V52S7-n6Iztho6TRcFw2y9a3jsZsCbc6XmVh5fbXhk4",
                foodImage = "https://tatsatchronicle.com/wp-content/uploads/2022/01/Akshaya-Patra-Foundation-.jpg",
            ),
            NGO(
                name = "Food for Life",
                location = LatLng(19.062124, 72.829983),
                members = "500+",
                feeding = "150",
                donorImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShMw7itm5NFNon2D1L8D9LfBTlmubgIo6s3g&s",
                foodImage = "https://curlytales.com/wp-content/uploads/2020/04/574ce89b-52d9-43d3-9c96-98eee5060085.jpeg",
            ),
            NGO(
                name = "Roti Bank Mumbai",
                location = LatLng(19.028461, 72.845226),
                members = "800+",
                feeding = "200",
                donorImage = "https://static.wixstatic.com/media/11062b_7f51861bc7774e5583d4fc80a42c62bb~mv2.jpg/v1/fill/w_188,h_188,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/11062b_7f51861bc7774e5583d4fc80a42c62bb~mv2.jpg",
                foodImage = "https://static.wixstatic.com/media/11062b_3165226178004602919fd4f2c40c6860~mv2.jpg/v1/fill/w_640,h_426,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/11062b_3165226178004602919fd4f2c40c6860~mv2.jpg",
            ),
            NGO(
                name = "Annakshetra Foundation",
                location = LatLng(19.055892, 72.813745),
                members = "600+",
                feeding = "175",
                donorImage = "https://annakshetra.org/wp-content/uploads/2020/03/Annakshetra-Logo-1.png",
                foodImage = "https://annakshetra.org/wp-content/uploads/2020/04/food-distribution-covid19.jpg",
            )
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(listOfNGO) { ngo ->
                NGOCard(ngo)
            }
        }
    }
}