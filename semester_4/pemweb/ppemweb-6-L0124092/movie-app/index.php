<?php
include 'connection.php';

$data = mysqli_query($conn, "SELECT * FROM movies");
?>

<!DOCTYPE html>
<html>
<head>
    <title>Movie Data</title>
</head>
<body>

<h2>Movie Data</h2>

<a href="/movie-app/add.php">+ Add Movie</a>

<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>No</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Year</th>
        <th>Action</th>
    </tr>

    <?php
    $no = 1;
    while($row = mysqli_fetch_assoc($data)) {
    ?>

    <tr>
        <td><?= $no++; ?></td>
        <td><?= $row['title']; ?></td>
        <td><?= $row['genre']; ?></td>
        <td><?= $row['year']; ?></td>
        <td>
            <a href="/movie-app/edit.php?id=<?= $row['id']; ?>">UPDATE</a>

            <a href="/movie-app/delete.php?id=<?= $row['id']; ?>">DELETE</a>
            
        </td>
    </tr>

    <?php } ?>

</table>

</body>
</html>