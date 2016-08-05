<!DOCTYPE html>
<html lang="en">
<head>
<title>ExpenseTracker</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="/expensetracker/user/userhome.css" type="text/css" rel="stylesheet">
<link rel="icon" type="image/png" href="icon.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/expensetracker/user/canvasjs.min.js"></script>
<script type="text/javascript" src="/expensetracker/user/charts.js"></script>
<script type="text/javascript" src="/expensetracker/user/uploadvalidation.js"></script>
<script type="text/javascript" src="/expensetracker/user/header.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>
				ExpenseTracker <small>Know Ur Savings</small></h1>

				<ul class="nav navbar-nav navbar-right" id="topBar">
					<li><a href="https://www.youtube.com/watch?v=5ON5QW7E2jE"
						target="_blank"><span class="glyphicon glyphicon-film"></span>
							Demo</a></li>
					<li><a href="home.html"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>
				</ul>
				<div class="clear" style="clear:both; overflow:hidden; width:100%;"></div>
		</div>
			<ul class="nav nav-tabs nav-justified" id="menuBar">
    <li class="active" ><a data-toggle="tab" onclick="showaccounts()">Accounts</a></li>
    <li><a data-toggle="tab" onclick="addIncome()">Add Income</a></li>
    <li><a data-toggle="tab" onclick="addtransaction()">Add Expense</a></li>
    <li><a data-toggle="tab" onclick="uploadTransaction()">Upload Expense</a></li>
	<li><a data-toggle="tab" onclick="viewIncome()">View Income</a></li>
    <li><a data-toggle="tab" onclick="viewExpense()">View Expense</a></li>
    <li><a data-toggle="tab" onclick="viewSavings()">View Savings</a></li>
  </ul>

  <div class="tab-content">
    <div id="Accounts" class="tab-pane fade in active"></div>
    <div id="Add Income" class="tab-pane fade"></div>
    <div id="Add Transanction" class="tab-pane fade"></div>
    <div id="Upload Transaction" class="tab-pane fade"></div>
     <div id="View Income" class="tab-pane fade"></div>
    <div id="View Expense" class="tab-pane fade"></div>
    <div id="View Savings" class="tab-pane fade"></div>
  </div>
		</div>
		<br>
	 	<div id="leftBar">
	 		<ul class="list-group">
			  <li class="list-group-item list-group-item-success" ><strong>TranscationDetails</strong></li>
			  <li class="list-group-item list-group-item-success">Date</li>
			  <li class="list-group-item list-group-item-success">Description</li>
			  <li class="list-group-item list-group-item-success" >Category</li>
			 
			</ul>
			<ul class="list-group">
			  <li class="list-group-item list-group-item-info" id="charts"><strong>Display mode</strong></li>
			  <li class="list-group-item list-group-item-info" id="charts" onclick="barcharts()">Bar chart</li>
			  <li class="list-group-item list-group-item-info" id="charts" onclick="piecharts()">Pie chart</li>
			  <li class="list-group-item list-group-item-info" id="charts" onclick="areacharts()">Area chart</li>
			  <li class="list-group-item list-group-item-info" id="charts" onclick="linecharts()">Line chart</li>
			  <li class="list-group-item list-group-item-info" id="charts" onclick="columncharts()">Column chart</li>
			  <li class="list-group-item list-group-item-info" id="charts" onclick="doughnutcharts()">Doughnut chart</li>
			</ul>
		</div>
		<div id="chartContainer" onload="barcahrts()" style="height: 500px; width: 70%;">		  

	<div id="allAccount">	


	<table class="table table-hover">
			<thead>
			  <tr>
				<th>Serial No</th>
				<th>Account number</th>
				<th>Account nickname</th>
			  </tr>
			</thead>
  		</table>

		<ul>
			<#list accountsdetails as ad>
				<li>${ad.accountnumber}-----${ad.nickname}</li>
			</#list>
		</ul>
	<ul class="pagination pagination-md" id="pagination">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
  	</ul>
	</div>

	<div id="addIncome">
		<div class="panel panel-default">
			<div class="panel-body"><strong>Add Income</strong></div>
		  </div>

		<form role="form" name="incomeform" method="post" action="/expensetracker/rest/user/income">
			<div class="form-group">
			  <input type="number" class="form-control" id="text" name="accountNumber" placeholder="Account Number">
			</div>
			<div class="form-group">
			  <input type="number" class="form-control" id="text" name="amount" placeholder="Amount">
			</div>
			<div class="form-group">
			  <input type="date" class="form-control" id="text" name="date" placeholder="Date">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		  </form>

	</div>

	<div id="addTransaction">
			<div class="panel panel-default">
			<div class="panel-body"><strong>Add Expense</strong></div>
		  </div>
				<form role="form" name="expenseform" method="post" action="rest/user/expense">
			<div class="form-group">
			  <input type="text" class="form-control" id="text" name="accountNumber" placeholder="Account Number">
			</div>
			<div class="form-group">
			  <input type="date" class="form-control" id="text" name="date" placeholder="Transaction Date">
			</div>
				<div class="form-group">
			  <input type="text" class="form-control" id="text" name="description" placeholder="Transaction Description">
			</div>
			<div class="form-group">
			  <input type="number" class="form-control" id="text" name="amount" placeholder="Amount">
			</div>
				<div class="form-group">
			  <input type="text" class="form-control" id="text" name="category" placeholder="Category">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		  </form>


	</div>

	<div id="uploadTransaction">
		<div class="panel panel-default">
   			 <div class="panel-body"><strong>Upload Transaction</strong></div>
  		</div>
  		<form action="rest/user/upload" method="post" enctype="multipart/form-data" onsubmit="return CheckExtension()">	
		<p>
			Select a file : <input type="file" name="uploadedFile" accept=".csv" />
		</p>
		
			<input type="submit" value="Upload It" /><br/><br/>
			<a href="account.csv" target="_blank">Dowload demo.csv</a><br/>
		</form>
	</div>

	<div id="viewIncome">
		

		<table class="table table-hover">
			<thead>
			  <tr>
				<th>Serial No</th>
				<th>Account number</th>
				<th>Amount</th>
				<th>Date</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td>1</td>
				<td>Doe</td>
				<td>john@example.com</td>
				<td>john@example.com</td>
			  </tr>
			  <tr>
				<td>2</td>
				<td>Moe</td>
				<td>mary@example.com</td>
				<td>john@example.com</td>
			  </tr>
			  <tr>
				<td>3</td>
				<td>Dooley</td>
				<td>july@example.com</td>
				<td>john@example.com</td>
			  </tr>
			</tbody>
  		</table>

		
	<ul class="pagination pagination-md" id="pagination">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
  	</ul>
	</div>

		<div id="viewExpense">
		<table class="table table-hover">
			<thead>
			  <tr>
				<th>Serial No</th>
				<th>Account number</th>
				<th>Transaction Date</th>
				<th>Transaction Description</th>
				<th>Amount</th>
				<th>Category</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td>1</td>
				<td>Doe</td>
				<td>john@example.com</td>
				<td>john@example.com</td>
				<td>john@example.com</td>
				<td>john@example.com</td>
			  </tr>
			  <tr>
				<td>2</td>
				<td>Moe</td>
				<td>mary@example.com</td>
				<td>john@example.com</td>
				<td>mary@example.com</td>
				<td>john@example.com</td>
				
			  </tr>
			  <tr>
				<td>3</td>
				<td>Dooley</td>
				<td>july@example.com</td>
				<td>john@example.com</td>	
				<td>mary@example.com</td>
				<td>john@example.com</td>
			  </tr>
			</tbody>
  		</table>

		
	<ul class="pagination pagination-md" id="pagination">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
  	</ul>
	</div>

	<div id="viewSavings">
		<table class="table table-hover">
			<thead>
			  <tr>
				<th>Serial No</th>
				<th>Account number</th>
				<th>Income</th>
				<th>Expense</th>
				<th>Savings</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td>1</td>
				<td>Doe</td>
				<td>john@example.com</td>
				<td>john@example.com</td>
				<td>john@example.com</td>
			  </tr>
			  <tr>
				<td>2</td>
				<td>Moe</td>
				<td>mary@example.com</td>
				<td>john@example.com</td>
				<td>mary@example.com</td>
				
			  </tr>
			  <tr>
				<td>3</td>
				<td>Dooley</td>
				<td>july@example.com</td>
				<td>john@example.com</td>	
				<td>mary@example.com</td>
			  </tr>
			</tbody>
  		</table>

		
	<ul class="pagination pagination-md" id="pagination">
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
  	</ul>
	</div>
	</div>
</body>
</html>
