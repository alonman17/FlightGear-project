import React from 'react';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import { Bar } from 'react-chartjs-2';
import faker from 'faker';

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

export const options = {
  responsive: true,
  plugins: {
    legend: {
      position: 'top',
    },
    title: {
      display: true,
      text: ' Bar Chart',
    },
  },
};


export function BarChart(props) {
  const labels=Object.keys(props.object)
  console.log(labels + " "+ props.object[labels[0]])
  const data = {
    labels,
    datasets: [
      {
        label: 'Dataset',
        data: labels.map((key) => props.object[key]),
        backgroundColor: 'rgba(255, 99, 132, 0.5)',
      },
     
    ],
  };
  return  <Bar options={options} data={data} />;
}
