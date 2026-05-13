<?php
include 'connection.php';

$id = $_GET['id'];

$data = mysqli_query($conn, "SELECT * FROM movies WHERE id='$id'");
$row = mysqli_fetch_assoc($data);

if(isset($_POST['submit'])) {

    $title = $_POST['title'];
    $genre = $_POST['genre'];
    $year = $_POST['year'];

    mysqli_query($conn, "UPDATE movies SET
        title='$title',
        genre='$genre',
        year='$year'
        WHERE id='$id'
    ");

    header("Location: index.php");
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Update Movie</title>
</head>
<body>

<h2>Update Movie</h2>

<form method="POST">

    <label>Title</label><br>
    <input type="text" name="title" value="<?= $row['title']; ?>" required><br><br>

    <label>Genre</label><br>
    <input type="text" name="genre" value="<?= $row['genre']; ?>" required><br><br>

    <label>Year</label><br>
    <input type="number" name="year" value="<?= $row['year']; ?>" required><br><br>

    <button type="submit" name="submit">UPDATE</button>

</form>

</body>
</html>