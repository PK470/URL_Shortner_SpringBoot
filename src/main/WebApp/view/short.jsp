<%@page language = "java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>URL Shortener</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f8f9fa;
        }
        .container {
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container text-center" style="width: 500px;">
        <h3 class="mb-4">Shorten Your URL</h3>
        <div class="input-group mb-3">
            <input id="shortened-url" type="text" class="form-control" value="http://127.0.0.1:8080/${url.shortUrl}" aria-describedby="button-addon2" readonly>
            <button class="btn btn-success " onclick="copyURL()" id="button-addon2">Copy URL</button>
        </div>
        <p><strong>Long URL:</strong> <a href="" target="_blank">${url.longUrl}</a></p>
        <div class="d-grid gap-2 ">
            <a href="/count/${url.shortUrl}" class="btn btn-secondary "style="width: 250px;">Total clicks of your short URL</a>
            <a href="/" class="btn btn-success " style="width: 250px;">Shorten another URL</a>
        </div>
        <p class="mt-3 text-muted" style="font-size: 0.9em;">* Short URLs that do not have at least one click per month are disabled</p>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function copyURL() {
            const input = document.getElementById('shortened-url');
            input.select();
            input.setSelectionRange(0, 99999); // For mobile devices
            document.execCommand("copy");
            alert("Copied: " + input.value);
        }
    </script>
</body>
</html>
