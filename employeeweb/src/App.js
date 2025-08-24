import PostUser from "./pages/employee/PostUser";
import { Routes, Route } from "react-router-dom";
import Header from "./pages/header/Header";
import Dashboard from "./pages/dashboard/Dashboard";
import NoMatch from "./pages/noMatch/NoMatch"; // fixed double slash
import UpdateUser from "./pages/employee/UpdateUser";

function App() {
    return (
        <>
            <Header />
            <Routes>
                <Route path='/' element={<Dashboard />} />
                <Route path='/add-employee' element={<PostUser />} /> {/* path now matches nav link */}
                 <Route path='/employee/:id' element={<UpdateUser />} /> {/* path now matches nav link */}
                <Route path='*' element={<NoMatch />} />

            </Routes>
        </>
    );
}

export default App;
