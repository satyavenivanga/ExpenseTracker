<html>
	<head>
		<title>expense tracker</title>
	</head>
	
	<body>
		<ul>
			<#list incomedetails as id>
				<li>${id.accountNubmer}-----${id.amount}---------${id.date}</li>
			</#list>
		</ul>
	</body>
</html>