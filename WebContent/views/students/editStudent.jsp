<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>Edit | Student Management System</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	
	<div class="container">
		<h3 class="text-center">Edit Student Profile</h3>
		
		<form class="form" action=<%= request.getContextPath() + "/students/update" %> method="POST">
			
			<input type="hidden" name="id" value=${ student.id } />
		
			<table class="table table-striped">
				<tr>
					<th>Name</th>
					<td>
						<input type="text" name="name" class="form-control" value="${ student.name }" />
					</td>
				</tr>
				<tr>
					<th>Address</th>
					<td>
						<input type="text" name="address" class="form-control" value="${ student.address }" />
					</td>
				</tr>
				<tr>
					<th>Country</th>
					<td>
						<select name="country" id="country" class="form-control">
							<option ${ student.country == 'Nepal' ? 'selected' : '' }>Nepal</option>
							<option ${ student.country == 'USA' ? 'selected' : '' }>USA</option>
							<option ${ student.country == 'Canada' ? 'selected' : '' }>Canada</option>
							<option ${ student.country == 'Australia' ? 'selected' : '' }>Australia</option>
							<option ${ student.country == 'India' ? 'selected' : '' }>India</option>
							<option ${ student.country == 'Belgium' ? 'selected' : '' }>Belgium</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Gender</th>
					<td>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender" id="femaleRadioBtn" value="Female" ${ student.gender == 'Female' ? 'checked' : '' } />
							<label class="form-check-label" for="femaleRadioBtn">Female</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender" id="maleRadioBtn" value="Male" ${ student.gender == 'Male' ? 'checked' : '' } />
							<label class="form-check-label" for="maleRadioBtn">Male</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender" id="otherRadioBtn" value="Other" ${ student.gender == 'Other' ? 'checked' : '' } >
							<label class="form-check-label" for="otherRadioBtn">Other / Rather not specify</label>
						</div>
					</td>
				</tr>
				<tr>
					<th>Hobbies</th>
					<td>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="hobbies" id="swimmingCheckBox" value="Swimming" ${ fn:containsIgnoreCase(student.stringifiedHobbies, "Swimming") ? 'checked' : '' } />
							<label class="form-check-label" for="swimmingCheckBox">Swimming</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="hobbies" id="singingCheckBox" value="Singing" ${ fn:containsIgnoreCase(student.stringifiedHobbies, "Singing") ? 'checked' : '' } />
							<label class="form-check-label" for="singingCheckBox">Singing</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="hobbies" id="dancingCheckBox" value="Dancing" ${ fn:containsIgnoreCase(student.stringifiedHobbies, "Dancing") ? 'checked' : '' } />
							<label class="form-check-label" for="dancingCheckBox">Dancing</label>
						</div>
					</td>
				</tr>
				<tr>
					<th>Preferred Languages</th>
					<td>
						<select class="languages-multiple-select" multiple="multiple" name="languages" style="width: 100%">
							<option value="C" ${ fn:containsIgnoreCase(student.stringifiedLanguages, 'C') ? 'selected' : '' }>C</option>
							<option value="Rust" ${ fn:containsIgnoreCase(student.stringifiedLanguages, 'Rust') ? 'selected' : '' }>Rust</option>
							<option value="Java" ${ fn:containsIgnoreCase(student.stringifiedLanguages, 'Java') ? 'selected' : '' }>Java</option>
							<option value="Python" ${ fn:containsIgnoreCase(student.stringifiedLanguages, 'Python') ? 'selected' : '' }>Python</option>
							<option value="F#" ${ fn:containsIgnoreCase(student.stringifiedLanguages, 'F#') ? 'selected' : '' }>F#</option>
						</select>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="submit" value="Update Student" class="btn btn-primary" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
		    $(".languages-multiple-select").select2({
				width: "resolve",
			})
		});
	</script>
</body>
</html>