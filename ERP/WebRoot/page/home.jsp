<%@page contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
 %>
<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">
	
    <title>首页</title>
  <link href="<%=path%>/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<%=path%>/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src=".<%=path%>/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<%=path%>/assets/js/ie-emulation-modes-warning.js"></script>
  </head>

  <body>
<div id="col-md-7 column">
            <ul class="breadcrumb">
                <li>
                     <a href="#">首页</a>
                </li>
                <li>
                     <a href="#">目录</a>
                </li>
                <li class="active">
                    数据
                </li>
            </ul>
          
          
        <div class="carousel slide" id="carousel-663988">
        <ol class="carousel-indicators">
          <li data-target="#carousel-663988" data-slide-to="0">
          </li>
          <li data-target="#carousel-663988" data-slide-to="1">
          </li>
          <li data-target="#carousel-663988" data-slide-to="2">
          </li>
        </ol>
        <div class="carousel-inner">
          <div class="item">
            <img alt="" src="<%=path%>/assets/img/default.jpg" />
            <div class="carousel-caption">
              <h4>
                First Thumbnail label
              </h4>
              <p>
                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
              </p>
            </div>
          </div>
          <div class="item active left">
            <img alt="" src="<%=path%>/assets/img/default1.jpg" />
            <div class="carousel-caption">
              <h4>
                Second Thumbnail label
              </h4>
              <p>
                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
              </p>
            </div>
          </div>
          <div class="item next left">
            <img alt="" src="<%=path%>/assets/img/default2.jpg" />
            <div class="carousel-caption">
              <h4>
                Third Thumbnail label
              </h4>
              <p>
                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
              </p>
            </div>
          </div>
        </div> <a class="left carousel-control" href="#carousel-663988" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-663988" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
      </div>

      <h3></h3>
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200"  class="img-responsive" alt="Generic placeholder thumbnail" ">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder" >
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail" style="color: #ffffff">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>
</div>

            <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src=".<%=path%>/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="<%=path%>/assets/dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="<%=path%>/assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<%=path%>/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
