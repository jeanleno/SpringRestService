var companyId = 0;

app.controller('companyController', function($scope, $http, $window, $location, API_URL) {    
    
    //retrieve companies listing from API
    $http.get(API_URL + "companies")
            .success(function(response) {
                $scope.companies = response;
            });
    
    //show modal form
    $scope.toggle = function(modalstate, id) {
        $scope.modalstate = modalstate;

        switch (modalstate) {
            case 'add':
                $scope.form_title = "Add New Company";
                break;
            case 'edit':
                $scope.form_title = "Company Detail";
                $scope.id = id;
                $http.get(API_URL + 'companies/' + id)
                        .success(function(response) {
                            console.log(response);
                            $scope.company = response;
                        });
                break;
            default:
                break;
        }
        console.log("id=" + id);
        $('#modalCompany').modal('show');
    }

    //save new record / update existing record
    $scope.save = function(modalstate, id) {
        var url = API_URL;
        var method;
        
        //append company id to the URL if the form is in edit mode
        if (modalstate === 'edit'){
            url += "companies/" + id;
            method = "PUT"
        } else {
            url += "companies";
            method = "POST"
        }
        
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.company),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            if (response === true) {
                location.reload();
            } else {
                alert("It was not possible to create the company! Invalid parameters!")
            }
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured.');
        });
    }

    //delete record
    $scope.confirmDelete = function(id) {
        var isConfirmDelete = confirm('Are you sure you want this company?');
        if (isConfirmDelete) {
            $http({
                method: 'DELETE',
                url: API_URL + 'companies/' + id
            }).
                    success(function(data) {
                        console.log(data);
                        if (response === true) {
                            location.reload();
                        } else {
                            alert("It was not possible to delete the company! Invalid parameters!")
                        }
                    }).
                    error(function(data) {
                        console.log(data);
                        alert('Unable to delete');
                    });
        } else {
            return false;
        }
    }
    
    $scope.showOwners = function(id) {
        companyId = id;
        $('#modalOwner').modal('show');
        
    }
    
    $scope.addOwnerToCompany = function() {
        var url = API_URL + "companies/"+companyId+"/"+$scope.owner.name;
        
        $http({
            method: 'POST',
            url: url,
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            if (response === true) {
                location.reload();
            } else {
                alert("It was not possible to add owner to the company! Invalid parameters!")
            }
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured.');
        });
        
    }
});