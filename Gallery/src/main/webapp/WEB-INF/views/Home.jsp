<%@ include file="header.jsp"%>
<center>
<br>
<br>
<br>
<br>
<br>


<a href="test">testing</a>

	<div class="container shadow"
		style="background-color: white; width: 90%">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel"
			style="margin-bottom: 10px">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">

				<div class="item active">
					<img src="IMG_6214.jpeg" style="width: 100%; height: 400px">
					<div class="carousel-caption" style="text-align: left"></div>
				</div>
				<c:forEach items="${corlist}" var="prod">

					<div class="item">
						<img src="resources/images/${prod.name}.jpg"
							style="width: 100%; height: 400px">
						<div class="carousel-caption"></div>
					</div>

				</c:forEach>

			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<br>

	<div class="container shadow"
		style="background-color: white; width: 90%">
		<p style="text-align: left; font-size: 20px; margin-top: 9px">FEATURED
			IMAGES</p>
		<hr class="style18" style="margin: 9px 0px 15px">

		<c:set var="ang" scope="session" value="${0}" />

		<table style="width: 100%; margin-bottom: 10px;">

			<tr>

				<td style="padding: 15px; width: 50%""><c:forEach
						items="${toplist}" var="prod">

						<a href="oneview${prod.id}" style="text-decoration: none"> <img
							src="resources/images/${prod.name}.jpg" class="img-rounded"
							height="500px" width="100%">

							<p style="font-size: 16px; margin: 7px 10px">${prod.name}</p>
							<p style="margin: 0px 10px">${prod.cat_Id}</p>
						</a>


						<c:choose>
							<c:when test="${ang == 0}">
     </td><td style="padding:15px">
<c:set var="ang" scope="session" value="${1}" />

							</c:when>
							<c:when test="${ang==1}">

</td></tr><tr><td style="padding:15px">
<c:set var="ang" scope="session" value="${0}" />

							</c:when>
						</c:choose>

					</c:forEach></td>
			</tr>
		</table>

	</div>


	<br>

</center>


<%@ include file="footer.jsp"%>