document.addEventListener('DOMContentLoaded', function () {
        const statusDropdown = document.getElementById('status');
        const activeButton = document.getElementById('activeButton');
        const deactiveButton = document.getElementById('deactiveButton');

        if(statusDropdown != null) {
            statusDropdown.addEventListener('change', function () {
                if (statusDropdown.value === 'active') {
                    activeButton.style.display = 'inline-block';
                    deactiveButton.style.display = 'none';
                } else if (statusDropdown.value === 'deactive') {
                    activeButton.style.display = 'none';
                    deactiveButton.style.display = 'inline-block';
                } else if (statusDropdown.value === 'action') {
                    activeButton.style.display = 'none';
                    deactiveButton.style.display = 'inline-block';
                }
            });
        }
});
