<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Homework_58</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="/js/script.js"></script>
</head>
<body class="no-scroll">
<div class="container">
    <div class="row justify-content-center">

        <div class="col col-lg-7 posts-container" id="posts">
            <!--<button class="btn" onclick="showSplashScreen()">Show Splash Screen</button>-->


        </div>
        <form id="form" name="form" enctype="multipart/form-data" action="/post" method="post">
            <input type="hidden" name="id" value="123">
            <input type="text" placeholder="Описание" name="des">
            <input type="file" name="photo" id="photo">
            <button type="button" id="addPost" onclick="a_fun()">Add</button>
        </form>

    </div>
</div>
<!-- Splash screen -->
<section id="page-splash" class="page-splash">
    <div class="card" id="registration-form">
        <div class="card-body">
            <h3 class="h3">Зарегистрируйтесь</h3>
        </div>
    </div>
    <button class="btn" onclick="hideSplashScreen()" style="font-size: 26px">Login</button>
</section>
</body>
</html>