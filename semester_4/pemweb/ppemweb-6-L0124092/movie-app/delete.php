<?php
include 'connection.php';

$id = $_GET['id'];

mysqli_query($conn, "DELETE FROM movies WHERE id='$id'");

header("Location: index.php");
?>