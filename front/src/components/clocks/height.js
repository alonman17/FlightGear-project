import React from "react";
import ReactDOM from "react-dom";
import ReactSpeedometer from "react-d3-speedometer";

export default function Height() {
  return (
    <div >
      <ReactSpeedometer
        value={500}
        labelFontSize={"15px"}
        valueTextFontSize={"15px"}
        paddingHorizontal={29}
        paddingVertical={29}
        currentValueText={"value: ${value}"}
      />
    </div>
  );
}

// const rootElement = document.getElementById("root");
// ReactDOM.render(<App />, rootElement);
