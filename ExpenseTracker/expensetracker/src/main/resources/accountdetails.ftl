<html>
	<head>
		<title>expense tracker</title>
	</head>
	
	<body>
		<ul>
			<#list accountsdetails as ad>
				<li>${ad.accountnumber}-----${ad.nickname}</li>
			</#list>
		</ul>
	</body>
</html>