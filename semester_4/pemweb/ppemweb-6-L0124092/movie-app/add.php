<?php
include 'connection.php';

if(isset($_POST['submit'])) {

    $title = $_POST['title'];
    $genre = $_POST['genre'];
    $year = $_POST['year'];

    $query = "INSERT INTO movies (title, genre, year)
              VALUES ('$title', '$genre', '$year')";

    mysqli_query($conn, $query);

    header("Location: index.php");
    exit;
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>

<h2>Add Movie</h2>

<form method="POST">

    <label>Title</label><br>
    <input type="text" name="title" required><br><br>

    <label>Genre</label><br>
    <input type="text" name="genre" required><br><br>

    <label>Year</label><br>
    <input type="number" name="year" required><br><br>

    <button type="submit" name="submit">SAVE</button>

</form>

</body>
</html>