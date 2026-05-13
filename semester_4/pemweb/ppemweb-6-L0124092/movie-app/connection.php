<?php

$conn = mysqli_connect("localhost", "calista", "12345", "movie_db");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

?>