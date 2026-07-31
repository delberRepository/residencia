import SectionHeader from "./SectionHeader";
import {
  Bed,
  BookOpen,
  DoorOpen,
  Building2
} from "lucide-react";

import foto1 from "../assets/foto1.png";
import foto2 from "../assets/foto2.png";

const spaces = [
  {
    title: "Basic",
    bed: "Cama 120x200",
    popular: false,
    src: foto2,
  },
  {
    title: "Premium",
    bed: "Cama 150x200",
    popular: true,
    src: foto1,
  },
];

function SpacesSection() {
  return (
      <section id="espacios" className="section spaces-section">
        <div className="section-inner">
          <SectionHeader
              title="Tus espacios personales"
              description="Dos tipos de habitación con equipamiento funcional, luz natural y todo lo necesario para el día a día universitario."
          />

          <div className="spaces-grid">
            {spaces.map((space) => (
                <article className="space-card" key={space.title}>
                  <div className="space-image">
                    {space.popular && (
                        <span className="space-badge">Popular</span>
                    )}

                    <img src={space.src} alt={space.title} />
                  </div>

                  <div className="space-content">
                    <h3>{space.title}</h3>

                    <ul>
                      <li>
                        <Bed size={20} />
                        {space.bed}
                      </li>

                      <li>
                        <BookOpen size={20} />
                        Zona de estudio
                      </li>

                      <li>
                        <DoorOpen size={20} />
                        Armario amplio
                      </li>

                      <li>
                        <Building2 size={20} />
                        Habitación exterior
                      </li>
                    </ul>
                  </div>
                </article>
            ))}
          </div>
        </div>
      </section>
  );
}

export default SpacesSection;