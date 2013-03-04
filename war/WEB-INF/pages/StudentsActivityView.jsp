<%-- 
    Document   : StudentsActivityView
    Created on : 27.02.2013, 21:58:03
    Author     : MorrDeck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="excanvas.js"></script><![endif]-->
        <script language="javascript" type="text/javascript" src="resources/js/jqPlot/jquery.min.js"></script>
        <script language="javascript" type="text/javascript" src="resources/js/jqPlot/jquery.jqplot.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.pieRenderer.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.donutRenderer.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/js/jqPlot/jquery.jqplot.css" />
        <script type="text/javascript" src="../src/plugins/jqplot.barRenderer.min.js"></script>
        <script type="text/javascript" src="../src/plugins/jqplot.categoryAxisRenderer.min.js"></script>
        <script type="text/javascript" src="../src/plugins/jqplot.pointLabels.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Students Activity</title>
    </head>
    <body>
    <center><h1>Students Activity</h1></center>
    <br>
    <center> <div id="chartdiv" style="height:500px;width:500px; alignment-adjust: middle " ></div></center>
        <script language="javascript" type="text/javascript">
            var data = [${data}];
            var plot1 = jQuery.jqplot ('chartdiv', [data],
            {
                title:'Отчет посещаемости собеседований',
                seriesDefaults: {
                    renderer: jQuery.jqplot.PieRenderer,
                    rendererOptions: {
                        seriesColors: [ "red", "blue"],
                        showDataLabels: true
                    }
                },
                legend: { show:true, location: 'e' }
            }
        );
            
        </script>
    </body>
</html>
