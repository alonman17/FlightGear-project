import React from "react";
import { useState } from "react";
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from "chart.js";
import { Line } from "react-chartjs-2";

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

export const options = {
  responsive: true,
  plugins: {
    legend: {
      position: "top",
    },
    title: {
      display: true,
      text: "Liner Graph",
    },
  },
};

export default function LineChartMonitoring(props) {
  const data = {
    labels: props.labels,
    datasets: [
      {
        label: "Dataset 1",
        data: props.data,
        borderColor: "rgb(255, 99, 132)",
        backgroundColor: "rgba(255, 99, 132, 0.5)",
      },
      {
        label: "Dataset 2",
        data: [100],
        borderColor: "rgb(53, 162, 235)",
        backgroundColor: "rgba(53, 162, 235, 0.5)",
      },
    ],
  };

  // const changeData = (d) => {
  //   console.log(data.datasets[0].data.length);
  //   console.log("this is d" + d);
  //   data.datasets[0].data.push(d);
  //   console.log(data);
  //   return data;
  // };
  return <Line options={options} data={data} />;
}
