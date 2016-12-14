<!DOCTYPE html>

<html lang="en">
<head>
    <title>home page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&subset=latin,cyrillic">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="app/res/css/bootstrap.min.css">
    <link rel="stylesheet" href="app/res/css/style.css">


    <!-- Polyfill(s) for older browsers -->
    <script src="node_modules/core-js/client/shim.min.js"></script>
    <script src="node_modules/zone.js/dist/zone.js"></script>
    <script src="node_modules/reflect-metadata/Reflect.js"></script>
    <script src="node_modules/systemjs/dist/system.src.js"></script>

    <script src="systemjs.config.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="app/res/js/bootstrap.min.js"></script>

    <script>
        System.import('app').catch(function(err){ console.error(err); });
    </script>
</head>
<body>
    <todo-app>
        <div class="container">
            <div class="row load_title">
                <h1><i class="fa fa-home" aria-hidden="true"></i>&nbsp;homeFLOW</h1>
            </div>
            <div class="cssload-loader-inner">
                <div class="cssload-cssload-loader-line-wrap-wrap">
                    <div class="cssload-loader-line-wrap"></div>
                </div>
                <div class="cssload-cssload-loader-line-wrap-wrap">
                    <div class="cssload-loader-line-wrap"></div>
                </div>
                <div class="cssload-cssload-loader-line-wrap-wrap">
                    <div class="cssload-loader-line-wrap"></div>
                </div>
                <div class="cssload-cssload-loader-line-wrap-wrap">
                    <div class="cssload-loader-line-wrap"></div>
                </div>
                <div class="cssload-cssload-loader-line-wrap-wrap">
                    <div class="cssload-loader-line-wrap"></div>
                </div>
            </div>
        </div>
    </todo-app>
</body>
</html>