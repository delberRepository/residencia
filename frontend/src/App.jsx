import './App.css'
import AboutSection from './components/AboutSection.jsx'
import ContactSection from './components/ContactSection.jsx'
import Footer from './components/Footer.jsx'
import HeroSection from './components/HeroSection.jsx'
import Navbar from './components/Navbar.jsx'
import ServicesSection from './components/ServicesSection.jsx'
import SpacesSection from './components/SpacesSection.jsx'
import PortfolioSection from "./components/PortfolioSection.jsx";

function App() {
  return (
    <>
      <Navbar />
      <main>
        <HeroSection />
        <AboutSection />
        <ServicesSection />
        <SpacesSection />
        <PortfolioSection/>
        <ContactSection />
      </main>
      <Footer />
    </>
  )
}

export default App
