import React from 'react';
import ReactTooltip from 'react-tooltip';

const Inventory = () => {
    const items = [
        { name: 'Sword', description: 'A sharp blade used for combat.' },
        { name: 'Potion', description: 'Heals 50 HP when consumed.' },
        { name: 'Shield', description: 'Provides protection against attacks.' }
    ];

    return (
        <div className="inventory">
            <h2>Player Inventory</h2>
            <ul>
                {items.map((item, index) => (
                    <li key={index} data-tip={item.description}>
                        {item.name}
                    </li>
                ))}
            </ul>
            <ReactTooltip />
        </div>
    );
};

export default Inventory;
