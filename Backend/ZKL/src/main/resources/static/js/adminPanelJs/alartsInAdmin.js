document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);

    function displayMessage() {
        if (urlParams.has("permissionAlreadyExist")) {
            alert("Failed! Permission Name Already Exists. Try Giving a Different Name.");
        }

        if (urlParams.has("PermissionUrlAlreadyExist")) {
            alert("Failed! Permission URL Already Exists. Try Giving a Different URL.");
        }

        if (urlParams.has("SomethingWentWrong")) {
            alert("Failed! Please try again.");
        }

        if (urlParams.has("PermissionAdded")) {
            alert("Permission Added Successfully.");
        }

        if (urlParams.has("PermissionNotExist")) {
            alert("Something Went Wrong. Please Try Again.");
        }

        if (urlParams.has("permissionDeleted")) {
            alert("Permission Deleted Successfully.");
        }

        if (urlParams.has("updatedPermission")) {
            alert("Permission Updated Successfully.");
        }

        if (urlParams.has("permissionSubCategoryAdded")) {
            alert("Permission Sub-Category Added Successfully.");
        }

        if (urlParams.has("permissionSubCategoryAlreadyExist")) {
            alert("Failed! Sub-Category Name Already Exists. Try Giving a Different Name.");
        }

        if (urlParams.has("permissionSubCategoryUrlAlreadyExist")) {
            alert("Failed! Sub-Category URL Already Exists. Try Giving a Different URL.");
        }

        if (urlParams.has("subCategoryNotExist")) {
            alert("Something Went Wrong. Please Try Again.");
        }

        if (urlParams.has("subCategoryDeleted")) {
            alert("Permission-Sub-Category Deleted Successfully.")
        }


        if (urlParams.has("updatedPermissionSubCategory")) {
            alert("Permission-Sub-Category Updated Successfully.")
        }
    }


    displayMessage();

});