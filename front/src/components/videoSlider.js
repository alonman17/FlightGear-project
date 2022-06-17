import React from "react";
import Slider from "@mui/material/Slider";

export default function DiscreteSlider() {
  return (
    <Slider
      style={{ position: "absolute", left: "50%", bottom: "80%", width: "20%" }}
      aria-label="joystick"
      defaultValue={0}
      valueLabelDisplay="auto"
      onChange={(e) => console.log(e.target.value)}
      min={0}
      step={0.01}
      max={1}
    />
  );
}
