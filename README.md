A collection of 4 mini Jetpack Compose projects focused on mastering LazyColumn, lists, MVVM, and UI design.

🚀 Project 1 – Number List (1 to 100)

Practiced LazyColumn

Displayed numbers in Card UI

Learned spacing, padding, item keys

Key Code:
LazyColumn {
    items((1..100).toList()) { num ->
        Card {
            Text("$num")
        }
    }
}

🍎 Project 2 – Fruit Name List (with ViewModel)

Data stored inside LogicViewModel

Displayed using items()

Simple clean UI with Card + Text

Key Code:
items(viewModel.textList) { fruit ->
    Card { Text(fruit) }
}

👤 Project 3 – Simple User List (Name + Age)

Used User data class

Displayed name + age with Row + Card

Practiced structuring list UI

Key Code:
items(viewModel.users) { user ->
    Row {
        Text(user.name)
        Text("${user.age} yrs")
    }
}

🎨 Project 4 – Advanced User List (Alternate Colors + Click Action)

Used itemsIndexed with index

Added alternating background card colors

Added item click → Toast message

Clean and modern UI layout

Key Code:
itemsIndexed(viewModel.users) { index, user ->
    Card(
        colors = CardDefaults.cardColors(viewModel.cardColours(index)),
        onClick = { /* Toast */ }
    ) {
        Text(user.name)
    }
}

🧠 Concepts Practiced

LazyColumn

items() & itemsIndexed()

MVVM (ViewModel → UI)

Card UI design

Click events inside LazyColumn

Spacing, padding, alignment

Custom colors and UI polish

📌 Author

Sujith
Android Developer — Jetpack Compose Learner 🚀
