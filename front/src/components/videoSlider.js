import React from "react";
import Slider from "@mui/material/Slider";

export default function DiscreteSlider(props) {
  // var timeSteps = [];
  // for (let i = 0; i < 10; i++) {
  //   props.setValue(i); //each time ateps
  // }

  return (
    <Slider
      style={{ position: "absolute", left: "50%", bottom: "80%", width: "20%" }}
      aria-label="slider"
      defaultValue={0.04}
      valueLabelDisplay="auto"
      // onChange={(e) => console.log(e.target.value)}
      value={props.setValue()}
      min={0}
      step={0.01}
      max={1} /////end time of the flight jason.tipmesteps the last
    />
  );
}
