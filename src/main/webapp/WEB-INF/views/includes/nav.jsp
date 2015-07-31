<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ctx}">Succulent</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="home"><a href="${ctx}">Home <span
						class="sr-only">(current)</span></a></li>
				<li class="dropdown user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">User<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${ctx}/viewwechat/userGroup">User Group</a></li>
						<li><a href="${ctx}/viewwechat/user">User</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
