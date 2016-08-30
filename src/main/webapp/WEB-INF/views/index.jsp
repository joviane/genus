<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Demo</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<base href="/" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body ng-app="app" ng-controller="home as home">
	<h1>Demo</h1>
	<div class="container">
		<div class="container" ng-show="!home.authenticated">
			Login with: <a href="/login">Github</a>
		</div>
		<div class="container" ng-show="home.authenticated">
			Logged in as: <span ng-bind="home.user"></span>
			<div>
				<button ng-click="home.logout()" class="btn btn-primary">Logout</button>
			</div>
		</div>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.min.js"></script>
	<script type="text/javascript">
		angular.module("app", []).controller("home", function($http) {
			var self = this;
			$http.get("/user").success(function(data) {
				self.user = data.userAuthentication.details.name;
				self.authenticated = true;
			}).error(function() {
				self.user = "N/A";
				self.authenticated = false;
			});
			self.logout = function() {
				$http.post('/logout', {}).success(function() {
					self.authenticated = false;
					$location.path("/");
				}).error(function(data) {
					console.log("Logout failed")
					self.authenticated = false;
				});
			};
		});
	</script>
</body>
</html>