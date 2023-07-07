import React, { useState } from "react";
import * as actions from "../utils/actions";
import { connect } from "react-redux";
import axios from "../utils/axios";

const Options = (props) => {
  const [fontStyle, setFontStyle] = useState("Ariel");

  const fonts = [
    "Arial",
    "Comic Sans",
    "Courier New",
    "Helvetica",
    "sans serif",
    "mono",
  ];

  const handleChange = (event) => {
    const selectedValue = event.target.value;
    setFontStyle(selectedValue);
    props.setFontStyleRedux(selectedValue);
  };

  const submitHandler = (event) => {
    console.log(props.pasteBody);
    console.log(props.pasteTitle);
    const data = {
      title: props.pasteTitle,
      text: props.pasteBody,
    };
    axios
      .post("savePaste", data)
      .then((res) => {
        console.log(res);
        const shortUrl = res?.data.url;
        window.location.href = `${window.location.origin}/${shortUrl}`;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const goToNewPage = () => {
    const baseUrl = window.location.origin;
    window.location.href = baseUrl;
  };

  return (
    <div className="options">
      <div className="options__font">
        <h3>Font Style : </h3>
        <select selectedvalue={fontStyle} onChange={handleChange}>
          {fonts?.map((font) => {
            return (
              <option key={font} value={font}>
                {font}
              </option>
            );
          })}
        </select>
      </div>
      <button
        className="options__btn"
        onClick={props.disabled ? goToNewPage : submitHandler}
      >
        {props.disabled ? "Create New Paste" : "Submit"}
      </button>
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    pasteBody: state.body,
    pasteTitle: state.title,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    setFontStyleRedux: (fontStyle) =>
      dispatch({ type: actions.CHANGE_FONT_STYLE, font_style: fontStyle }),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Options);
