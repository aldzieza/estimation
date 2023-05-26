
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<%--<html lang="pl" xmlns:th="http://www.thymeleaf.org">--%>

<head>
<%--    <meta charset="UTF-8">--%>
    
   
<!--    <link rel="stylesheet" href="../../static/style.css" th:href="@{style.css}">-->

<meta charset="ISO-8859-1">
<title>Chart Classification Supplier </title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
		$(document).ready(function(){
			
			$.ajax({
				type: 'GET',
				dataType:"json",
				contentType:"application/json",
				url:'${pageContext.request.contextPath}/api/SupClassification',
				success:function(result){
					google.charts.load('current',{
						'packages':['corechart']
					});
					google.charts.setOnLoadCallback(function(){
						drawChart(result);
					});
				}		
			});
			function drawChart(result){
				
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Classification');
				data.addColumn('number','Number Suppliers');
				var dataArray =[];
				$.each(result, function(i,obj){
					dataArray.push([obj.classification, obj.numberSuppliers]);
					});
				
					data.addRows(dataArray);
					
					var piechart_options = {
							title: 'Pie Chart:How Much Products Sold By last Night',
							width: 500,
							height: 400
					
					};
					
				var piechart = new google.visualization.PieChart(document
						.getElementById('piechart_div'));
				piechart.draw(data, piechart_options);
				
				var barchart_options = {
						title: 'Pie Chart:How Much Products Sold By last Night',
						width: 500,
						height: 400,
						legend:'none'
				};
				var barchart = new google.visualization.BarChart(document
						.getElementById('barchart_div'));
				barchart.draw(data, barchart_options);
				}	
		});
		</script>
		
</head>
<body>
<!-- @@@@@@@@@@@   HEADER SECTION   @@@@@@@@@@@ -->
<%--<header th:replace="fragments :: header"></header>--%>
<!-- @@@@@@@@@@@  -/- HEADER SECTION   @@@@@@@@@@@ -->
		<table class = "columns">
		<tr>
		<td><div id="piechart_div" style="border: 1px solid #ccc"></div></td>
		<td><div id="barchart_div" style="border: 1px solid #ccc"></div></td>
		</tr>
		</table>
		
</body>
</html>