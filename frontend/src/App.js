import "./style.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import Paste from "./components/Paste";

function App() {
  const path = window.location.pathname;
  const content = path.substring(1);

  return (
    <div className="App">
      <Header />
      <div className="container">
        <Paste disabled={content ? true : false} url={content ? content : ""} />
      </div>
      {/* <Footer /> */}
    </div>
  );
}

export default App;
