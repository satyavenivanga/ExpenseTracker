<html>
	<head>
		<title>expense tracker</title>
	</head>
	
	<body>
		<ul>
			<#list accountdetails as ad>
				<li>${ad.loginid}-----${ad.accountnumber}-----${ad.nickname}</li>
			</#list>
		</ul>
	</body>
</html>