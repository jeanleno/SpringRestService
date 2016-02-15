

app.controller('companyController', function($scope, $http, $window, $location, API_URL) {    
    
    //retrieve companies listing from API
    $http.get(API_URL + "getallcompanies")
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
                $http.get(API_URL + 'getcompany/' + id)
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
        
        //append company id to the URL if the form is in edit mode
        if (modalstate === 'edit'){
            url += "editcompany/" + id;
        } else {
            url += "createcompany";
        }
        
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.company),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            location.reload();
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured. Please check the log for details');
        });
    }

    //delete record
    $scope.confirmDelete = function(id) {
        var isConfirmDelete = confirm('Are you sure you want this company?');
        if (isConfirmDelete) {
            $http({
                method: 'DELETE',
                url: API_URL + 'deletecompany/' + id
            }).
                    success(function(data) {
                        console.log(data);
                        location.reload();
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
        //$window.location.href = 'owner.html?companyId='+id;
        $('#modalOwner').modal('show');
        
    }
    
    $scope.saveOwner = function(id) {
        var url = API_URL + "saveowner";
        
        
        
        $http({
            method: 'POST',
            url: url,
            data: JSON.stringify($scope.company),
            headers: {'Content-Type': 'application/json'}
        }).success(function(response) {
            console.log(response);
            location.reload();
        }).error(function(response) {
            console.log(response);
            alert('This is embarassing. An error has occured. Please check the log for details');
        });
        
    }
});