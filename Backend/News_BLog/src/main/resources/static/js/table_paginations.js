// Pagination letiables
const rowPerPageSelector = document.getElementById("navbarDropdown5");
let currentPage = 1;
let rowsPerPage = parseInt(rowPerPageSelector.value);

function rowValueChange() {
    rowsPerPage = parseInt(rowPerPageSelector.value);
    updateTable();
}

let currentUrl = window.location.href;
currentUrl = currentUrl.substring(currentUrl.lastIndexOf('/') + 1);
let rowStartsFrom;
let rowEndController;
if (currentUrl === "merchants") {
    rowStartsFrom = 2;
    rowEndController = 1;
} else {
    rowStartsFrom = 1;
    rowEndController = 0;
}
const table = document.getElementById("fresh-table");
// console.log(table);
const pageNumber = document.getElementById("pageNumber");
let rows = table.getElementsByTagName("tr");
// console.log(rows);
let totalRows = rows.length - rowStartsFrom; // Exclude the header row


let clickedForSortArray = [];

// Sorting function
function sortTable(column) {
    let rowsArray = [].slice.call(rows, rowStartsFrom);

    if (clickedForSortArray.includes(column)) {
        let index = clickedForSortArray.indexOf(column);
        clickedForSortArray.splice(index, 1);
        rowsArray.sort(function (a, b) {
            let aText = a.getElementsByTagName("td")[column].textContent.trim();
            let bText = b.getElementsByTagName("td")[column].textContent.trim();
            return bText.localeCompare(aText);
        });
    } else {
        clickedForSortArray.push(column);
        rowsArray.sort(function (a, b) {
            let aText = a.getElementsByTagName("td")[column].textContent.trim();
            let bText = b.getElementsByTagName("td")[column].textContent.trim();
            return aText.localeCompare(bText);
        });
    }
    for (let i = 0; i < rowsArray.length; i++) {
        table.tBodies[0].appendChild(rowsArray[i]);
    }
}

// Pagination functions
function prevPage() {
    if (currentPage > 1) {
        currentPage--;
        pageNumber.innerText = currentPage;
        updateTable();
    }
}

function nextPage() {
    if (currentPage < totalPages()) {
        currentPage++;
        pageNumber.innerText = currentPage;
        updateTable();
    }
}

function totalPages() {
    return Math.ceil(totalRows / rowsPerPage);
}

function updateTable() {
    let start = (currentPage - 1) * rowsPerPage + 1;
    let end = start + rowsPerPage - 1;

    for (let i = rowStartsFrom; i <= totalRows + rowEndController; i++) {
        if (i >= start && i <= end) {
            rows[i].style.display = "";
            // console.log(rows[i].textContent);
        } else {
            rows[i].style.display = "none";
            // console.log(rows[i].textContent);
        }
    }
}

// Search function
const searchFilter = document.getElementById("searchFilter");
const checkboxes = document.getElementById("checkboxes");

function searchFilterAndColumnVisualContents() {
    let headerRow = table.querySelector("thead tr");

    // Extract text content from each th and store in an array
    let headerStrings = Array.from(headerRow.children).map(function (th) {
        return th.textContent.trim();
    });
    headerStrings.forEach(function (header, index) {
        if (header !== "Action" && header !== "From Admin" && header !== "To Admin") {
            let option = document.createElement("option");
            option.textContent = header;
            option.value = index.toString();
            searchFilter.appendChild(option);

            if (checkboxes != null) {
                checkboxes.style.display = "none";
                let checkbox = document.createElement("input");
                checkbox.type = "checkbox";
                checkbox.value = index.toString();
                checkbox.id = "checkbox" + index; // Optional: Assign a unique ID to each checkbox
                checkbox.setAttribute("checked", "checked");
                checkbox.style.marginLeft = "5px";
                checkbox.setAttribute("onChange", "columnVisualSelectedValues(" + index + ")");
                let label = document.createElement("label");
                label.setAttribute("for", "checkbox" + index); // Optional: Associate the label with the checkbox
                // checkboxes.appendChild(checkbox);
                label.appendChild(checkbox);
                let span = document.createElement("span");
                span.textContent = header;
                span.style.marginLeft = "10px";
                span.style.color = "black";
                label.appendChild(span);
                checkboxes.appendChild(label);
                // checkboxes.appendChild(document.createElement("br")); // Optional: Add line break between checkboxes
            }
        }
    });
}

let expanded = false;

function showCheckboxes() {
    if (!expanded) {
        checkboxes.style.display = "block";
        expanded = true;
    } else {
        checkboxes.style.display = "none";
        expanded = false;
    }
}

let selectedColumn = []

function columnVisualSelectedValues(selectedValue) {
    selectedValue = parseInt(selectedValue);
    let index = selectedColumn.indexOf(selectedValue);

    if (selectedColumn.includes(selectedValue)) {
        selectedColumn.splice(index, 1);
    } else {
        selectedColumn.push(selectedValue);
    }
    updateColumnVisibility();
}

function updateColumnVisibility() {
    let columnName = rows[0].getElementsByTagName("th");
    for (let i = rowStartsFrom; i < rows.length; i++) {
        let cells = rows[i].getElementsByTagName("td");
        for (let j = 0; j < cells.length; j++) {
            if (selectedColumn.includes(j)) {
                if( columnName[j] != null) {
                    columnName[j].style.display = "none";
                }
                cells[j].style.display = "none";
            } else {
                if(columnName[j] != null) {
                    columnName[j].style.display = "";
                }
                cells[j].style.display = "";
            }
        }
    }
}

let searchFilterValue;

function searchFilterOnChangeValue() {
    searchFilterValue = parseInt(searchFilter.value);
}

document.getElementById("search").addEventListener("input", function () {
    let query = this.value.toLowerCase();
    for (let i = rowStartsFrom; i < rows.length; i++) {
        let name = rows[i].getElementsByTagName("td")[searchFilterValue].textContent.toLowerCase();
        if (name.includes(query)) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
    currentPage = 1; // Reset to the first page when searching
});

updateTable();
searchFilterAndColumnVisualContents();
