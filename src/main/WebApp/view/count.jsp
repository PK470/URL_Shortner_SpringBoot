<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Total URL Clicks</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
    rel="stylesheet"
  >
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      margin: 0;
      background-color: #f8f9fa;
    }
    .click-tracker {
      box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      background-color: #ffffff;
      padding: 20px;
    }
    .url {
      font-size: 1.2rem;
      font-weight: bold;
      color: #007bff;
      text-decoration: none;
    }
    .url:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="container click-tracker text-center" style="width: 500px;">
    <h3>Total URL Clicks</h3>
    <p class="text-muted">
      The number of clicks from the shortened URL that redirected the user to the destination page.
    </p>
    <a href="#" class="url">http://127.0.0.1:8080/${u.shortUrl}</a>
    <div class="my-3">
      <h1 class="display-4 fw-bold">${u.count}</h1>
    </div>
    <div class="my-3">
          <h5 class="fw-bold">No. of unique click:- ${unique}</h5>
        </div>
    <a href="/"class="btn btn-success mb-2" style="width: 250px;">Track clicks from another short URL</a>
    <a href ="/" class="btn btn-success" style="width: 250px;">Shorten another URL</a>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
