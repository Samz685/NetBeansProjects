/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package Spring_0.demo.repositories;

import Spring_0.demo.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Syzer
 */
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    
}
