document.addEventListener('DOMContentLoaded', function () {
    if (document != null) {
        var ctx = document.getElementById('stackedArea').getContext('2d');

        var myChart = new Chart(ctx, {

            type: 'line',

            data: {

                labels: ['January-23',

                    'February-23',

                    'March-23',

                    'April-23',

                    'May-23',
                    'Jun-23',
                    'July-23',
                    // 'August-23',
                    // 'September-23',
                    // 'October-23',
                    // 'November-23',
                    // 'December-23',
                ],

                datasets: [

                    {

                        label: 'Local',

                        data: [5000, 7500, 4000, 6000, 2000, 9000, 3000,],

                        backgroundColor: 'rgba(219, 238, 225, 0.5)',

                        borderColor: 'rgba(75, 192, 192, 1)',

                        borderWidth: 2,

                        fill: true,

                    },

                    {

                        label: 'International',

                        data: [2500, 1000, 4000, 3000, 3500, 6000, 2000],

                        backgroundColor: 'rgba(75, 192, 192, 0.5)',

                        borderColor: 'rgba(255, 99, 132, 1)',

                        borderWidth: 2,

                        fill: true,

                    },

                    {

                        label: 'Bounce Rate',

                        data: [10, 30, 5, 15, 20, 25, 10],

                        backgroundColor: 'rgba(54, 162, 235, 0.5)',

                        borderColor: 'rgba(54, 162, 235, 1)',

                        borderWidth: 2,

                        fill: true,

                    }

                ]

            },

            options: {

                scales: {

                    y: {

                        beginAtZero: true,

                        stacked: true,

                        title: {

                            display: true,

                            text: 'Statistics'

                        }

                    },

                    x: {

                        stacked: true

                    }

                },

                layout: {

                    padding: {

                        left: 20,

                        right: 20,

                        top: 20,

                        bottom: 20

                    }

                },

                plugins: {

                    legend: {

                        position: 'bottom',

                    },

                }

            }
        });
    }
});