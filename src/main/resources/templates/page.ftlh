<#ftl encoding='UTF-8'>
<#import "parts/navigation.ftlh" as nav>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<@nav.menu/>

<h1 align="center" style="margin-top: 2%"><u>${page.url}</u></h1>

<div class="scroll">
    <ul class="list-group">
        <li class="list-group-item list-group-item-info" style="border: none; text-align: center">
            The most frequently world:
            <strong> ${page.mostFrequentWord}</strong>
        </li>
        <#list page.words?keys as key>
            <li class="list-group-item" style="border: none">
                <strong>${key} - </strong>
                ${page.words[key]}
            </li>
        </#list>
    </ul>
</div>

<iframe class="html-page" src="${page.url}">

</iframe>
</body>
</html>