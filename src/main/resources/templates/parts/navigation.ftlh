<#macro menu>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }

        a:active {
            background-color: #4CAF50;
        }


        li:last-child {
            border-right: none;
            float: right;
        }

        body {
            margin: 0;
        }

        .card {
            height: 400px;
            margin-top: 2%;
            margin-left: 40%;
            box-shadow: black;
            border: #333333 solid 1px;
            border-radius: 3px;
        }

        .list-group-item {
            height: 70px;
        }

        .scroll {
            display: inline-block;
            background: #FFFAFA;
            overflow-y: scroll;
            width: 45%;
            height: 550px;
            margin-left: 6%;
            margin-top: 2%;
            border: grey 3px solid;
            border-radius: 6px;
        }

        .search {
            background: #FFFAFA;
            float: right;
            display: inline-block;
            margin-top: 5%;
            margin-right: 10%;
            height: 200px;
            width: 500px;
            border: grey solid 3px;
            border-radius: 5px;
            text-align: center;
        }

        .label {
            margin-left: 4%;
        }

        .search-input {
            width: 70%;
            margin-top: 8%;
            margin-left: 2%;
            display: inline;
        }

        h2 {
            margin-top: 2%;
        }

        .btn {
            margin: 4%;
        }

        .html-page {
            display: inline-block;
            width: 40%;
            height: 550px;
            margin-left: 6%;
            margin-top: 2%;
            border: grey 3px solid;
            border-radius: 6px;
        }
    </style>

    <ul>
        <li><a href="/profile">Profile</a></li>
        <li><a href="/pages">Searched pages</a></li>
        <li><a href="/logout">Log out</a></li>
    </ul>
</#macro>