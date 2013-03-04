<%-- 
    Document   : RegReport
    Created on : 01.03.2013, 17:04:06
    Author     : MorrDeck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script language="javascript" type="text/javascript" src="resources/js/jqPlot/jquery.min.js"></script>
        <script language="javascript" type="text/javascript" src="resources/js/jqPlot/jquery.jqplot.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/js/jqPlot/jquery.jqplot.css" />

        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.dateAxisRenderer.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.canvasTextRenderer.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.barRenderer.min.js"></script>

        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.canvasTextRenderer.min.js"></script>
        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.canvasAxisLabelRenderer.min.js"></script>

        <script type="text/javascript" src="resources/js/jqPlot/plugins/jqplot.dateAxisRenderer.min.js"></script> 





        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
    </head>
    <body>
        <h1>Отчет зарегистрировался/пришел</h1>
        <center> <div id="chartdiv" style="height:500px;width:500px;" ></div></center>
        <script language="javascript" type="text/javascript">
            var data = [${data}];
            var plot1b = $.jqplot('chartdiv', [data], {
                title: 'Отчет пришедших и арегестрированных',
                animate: true,
                animateReplot: true,
                seriesColors: [ "green"],
                series:[{renderer:$.jqplot.BarRenderer}],
                axesDefaults: {
                    tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
                    tickOptions: {
                        fontFamily: 'Georgia',
                        fontSize: '10pt',
                        angle: -30
                    }
                },
                axes: {
                    xaxis: {
                        renderer: $.jqplot.CategoryAxisRenderer
                    }
                }
            });
        </script>
    </body>
</html>
