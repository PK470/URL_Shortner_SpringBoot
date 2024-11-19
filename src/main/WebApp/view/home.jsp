<%@page language = "java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>URL</title>
</head>
<body>
    <div class="container  border-secondary p-2 bg-light border mx-auto my-5" style="width: 500px;">

        <form method="post" action="/url-short">
            <label for="url" class="form-label">Paste the URL to be shortened</label>
            <div class="input-group mb-3">

              <input type="text" name = "url" class="form-control"  aria-describedby="button-addon2" required>
              <button class="btn btn-success" type="submit" id="button-addon2">Submit</button>
            </div>
        </form>

    </div>
  </body>
</html>
