package com.soham.spithacks2.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDonationScreen() {
    var foodName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var showCategoryDropdown by remember { mutableStateOf(false) }

    val primaryTeal = Color(0xFF3D8D89)
    val lightTeal = Color(0xFFE5F0F0)

    val categories = listOf("Vegetarian", "Non-Vegetarian", "Vegan", "Other")
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Text(
            text = "Add Donation",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Food Name
        OutlinedTextField(
            value = foodName,
            onValueChange = { foodName = it },
            label = { Text("Food Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryTeal,
                focusedLabelColor = primaryTeal,
                cursorColor = primaryTeal
            )
        )

        // Quantity
        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity (in servings)") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryTeal,
                focusedLabelColor = primaryTeal,
                cursorColor = primaryTeal
            )
        )

        // Category Dropdown
        ExposedDropdownMenuBox(
            expanded = showCategoryDropdown,
            onExpandedChange = { showCategoryDropdown = !showCategoryDropdown }
        ) {
            OutlinedTextField(
                value = selectedCategory,
                onValueChange = {},
                readOnly = true,
                label = { Text("Category") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showCategoryDropdown) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = primaryTeal,
                    focusedLabelColor = primaryTeal
                )
            )
            ExposedDropdownMenu(
                expanded = showCategoryDropdown,
                onDismissRequest = { showCategoryDropdown = false }
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            selectedCategory = category
                            showCategoryDropdown = false
                        }
                    )
                }
            }
        }

        // Expiry Date
        OutlinedTextField(
            value = expiryDate,
            onValueChange = {},
            label = { Text("Expiry Date") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { showDatePicker = true }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Select date")
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryTeal,
                focusedLabelColor = primaryTeal
            )
        )

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("OK", color = primaryTeal)
                    }
                }
            ) {
                DatePicker(
                    state = rememberDatePickerState(),
                    colors = DatePickerDefaults.colors(
                        selectedDayContainerColor = primaryTeal
                    )
                )
            }
        }

        // Location
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryTeal,
                focusedLabelColor = primaryTeal,
                cursorColor = primaryTeal
            )
        )

        // Upload Image Button
        ElevatedButton(
            onClick = {
                // Intent to open gallery would go here
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = lightTeal,
                contentColor = primaryTeal
            )
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Upload Image",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Upload Image")
        }

        // Submit Button
        Button(
            onClick = { /* Handle submission */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryTeal
            )
        ) {
            Text("Submit Donation")
        }

        // Spacing at the bottom for better scrolling experience
        Spacer(modifier = Modifier.height(16.dp))
    }
}

// Preview
//@Composable
//@Preview(showBackground = true)
//fun PreviewAddDonationScreen() {
//    MaterialTheme {
//        AddDonationScreen()
//    }
//}