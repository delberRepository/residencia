import { useEffect, useState } from 'react'
import foto1 from '../portfolio/1.png'
import foto2 from '../portfolio/2.png'
import foto3 from '../portfolio/3.png'
import foto4 from '../portfolio/4.jpg'
import foto5 from '../portfolio/5.jpeg'
import SectionHeader from "./SectionHeader.jsx";




const portfolioPhotos = [
    {
        src: foto1,
        alt: 'Residencia',

    },
    {
        src: foto2,
        alt: 'Estudiantes',

    },


    {
        src: foto3,
        alt: 'Estudiantes',

    },
    {
        src: foto4,
        alt: 'Habitación',

    },
    {
        src: foto5,
        alt: 'Habitación',

    },

]

function Portfolio() {
    const [selectedPhoto, setSelectedPhoto] = useState(null)

    useEffect(() => {
        if (!selectedPhoto) {
            return undefined
        }

        const handleKeyDown = (event) => {
            if (event.key === 'Escape') {
                setSelectedPhoto(null)
            }
        }

        window.addEventListener('keydown', handleKeyDown)

        return () => window.removeEventListener('keydown', handleKeyDown)
    }, [selectedPhoto])

    return (
        <section id="espacios" className="section">
            <div className="section-inner">

                <SectionHeader
                    title="Nuestras instalaciones"
                    description=""
                />

                <div className="portfolio-grid">
                    {portfolioPhotos.map((photo, index) => (
                        <button
                            key={photo.src}
                            type="button"
                            className="portfolio-item"
                            onClick={() => setSelectedPhoto(photo)}
                            aria-label={`Abrir foto: ${photo.alt}`}
                        >
                            <img src={photo.src} alt={photo.alt} className="portfolio-photo" />
                        </button>
                    ))}
                </div>
            </div>

            {selectedPhoto ? (
                <div
                    className="portfolio-modal"
                    role="dialog"
                    aria-modal="true"
                    aria-label={selectedPhoto.alt}
                    onClick={() => setSelectedPhoto(null)}
                >
                    <div
                        className="portfolio-modal-content"
                        onClick={(event) => event.stopPropagation()}
                    >
                        <button
                            type="button"
                            className="portfolio-modal-close"
                            onClick={() => setSelectedPhoto(null)}
                            aria-label="Cerrar foto"
                        >
                            ×
                        </button>
                        <img
                            src={selectedPhoto.src}
                            alt={selectedPhoto.alt}
                            className="portfolio-modal-photo"
                        />
                    </div>
                </div>
            ) : null}
        </section>
    )
}

export default Portfolio
