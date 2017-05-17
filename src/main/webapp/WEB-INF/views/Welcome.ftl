<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#list goods as good>
    ${good.goodName},${good.goodDescription},${good.goodPic}
</#list>

</body>
</html>